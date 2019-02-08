(ns miracle.window.sample-view
  (:require [arcadia.core :refer :all]
            [miracle.window.editor :refer :all])
  (:import UnityEngine.GUILayout
           MiracleSampleWindow))

(defn on-gui
  [obj]
  (let [pos (.position obj)
        w (.width pos)
        elem-w 30]
    (horizontal
     (label "" nil  (GUILayout/Width elem-w))
     (label "Hello"))
    
    (horizontal
     (label "Cool" nil (GUILayout/Width elem-w))
     (label "Yeah"))))
