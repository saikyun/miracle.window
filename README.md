# miracle.window
Unity editor windows using Clojure in Arcadia 

# Dependencies
[Arcadia](https://github.com/arcadia-unity/Arcadia), master branch commit [v1.0.3 beta](https://github.com/arcadia-unity/Arcadia/commit/488e64be85d242467729fff471a00916ffb6c3fa)

# Usage
1. `cd Assets/`
2. `git clone https://github.com/Saikyun/miracle.window`
3. Start Unity
4. Look under `Window/Miracle Sample`
5. Done!

![Miracle sample window](https://memset.se/6519/4fd04ab772b3f614731ee614e2ffb622e22e0b9c)  
_Expected result_

# What now?

Look at `src/miracle/window/sample_view.clj` and `src/miracle/window/editor.clj`. All functions are just thin wrappers around the Unity counter parts. I've tried to make the macros easy to call but also flexible enough to cover multiple use cases.

```clojure
;; These examples aren't runnable straight from the repl, because GUI functions can only be called from
;; a UnityWindows OnGUI function.
(label "Cool")
(label "Cool" (get-style "Button"))
(label "Cool" nil (GUILayout/Width 30))
```

1. `label` is the kind of UI element.
2. `"Cool"` is the string to show. This parameter is always required. The number of parameters here depends on the UI element, `label` only wants a string.
3. `nil` is the active unity skin style. When the parameter is `nil`, the default for the UI element is used, in this case `GUI.skin.GetStyle("Button")`. Read more [here](https://docs.unity3d.com/ScriptReference/GUISkin.GetStyle.html).
4. At the end you can put any number of `GUILayout` options. Read more [here](https://docs.unity3d.com/ScriptReference/GUILayoutOption.html).

# In your own project
You're supposed to create your own versions of the sample files. `editor.clj` is the only actual library file.
If you add more UI elements to `editor.clj`, please make a pull request!
