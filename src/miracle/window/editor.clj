(ns miracle.window.editor
  (:require  [clojure.string :as str])
  (:import UnityEngine.GUILayoutOption
           UnityEngine.GUILayout))

(defn get-style
  [name]
  (.. GUI skin (GetStyle name)))

(defmacro std-style
  [f name & [style options & args]]
  `(~f
    ~@args
    (or ~style (miracle.window.editor/get-style ~name))
    (into-array UnityEngine.GUILayoutOption (or ~options []))))

(defn text-field
  [str & [style & options]]
  (miracle.window.editor/std-style
   EditorGUILayout/TextField 
   "TextField"
   style
   options
   str))

(defn delayed-text-field
  [str & [style & options]]
  (miracle.window.editor/std-style
   EditorGUILayout/DelayedTextField 
   "TextField"
   style
   options
   str))

(defn button
  [str & [style & options]]
  (miracle.window.editor/std-style
   GUILayout/Button
   "Button"
   style
   options
   str))

(defn toggle
  [a b]
  (let [res    (EditorGUILayout/Toggle
                "Toogle"
                b
                (.. GUI skin (GetStyle "Toggle"))
                (make-array GUILayoutOption 0))]
    (set! 
     (.. a myBool)
     res)))

(defn label
  [str & [style & options]]
  (miracle.window.editor/std-style GUILayout/Label "Label" style options str))

(defn static-text-field
  [str]
  (std-style
   EditorGUILayout/TextField 
   "Text Field" 
   str))

(defmacro horizontal
  [& children]
  `(do
     (miracle.window.editor/std-style EditorGUILayout/BeginHorizontal "Label")
     ~@children
     (EditorGUILayout/EndHorizontal)))

(defmacro vertical
  [& children]
  `(do
     (miracle.window.editor/std-style EditorGUILayout/BeginVertical "Label")
     ~@children
     (EditorGUILayout/EndVertical)))
