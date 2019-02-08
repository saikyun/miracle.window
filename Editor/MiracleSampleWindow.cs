using UnityEngine;
using UnityEditor;
using System.Collections.Generic;
using UnityEditor.IMGUI.Controls;
using clojure.lang;
using Arcadia;

class MiracleSampleWindow : EditorWindow
{
  private static Var onGuiVar;
  
  [MenuItem("Window/Miracle Sample")]
  static void Init() {
    Arcadia.Util.require("miracle.window.sample-view");
    onGuiVar = RT.var("miracle.window.sample-view", "on-gui");
    MiracleSampleWindow window = (MiracleSampleWindow)EditorWindow.GetWindow(typeof(MiracleSampleWindow));
    window.title = "Miracle";
    window.Show();
  }
  
  void OnGUI() {
    Arcadia.Util.require("miracle.window.sample-view");
    onGuiVar = RT.var("miracle.window.sample-view", "on-gui");
    onGuiVar.invoke(this);
  }
}
