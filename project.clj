(defproject pandora "0.1.0-SNAPSHOT"
  :description "OpenGL made alluringly easy"
  :url "https://github.com/jargon/pandora"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.lwjgl.lwjgl/lwjgl "2.9.1"]
                 [org.lwjgl.lwjgl/lwjgl_util "2.9.1"]
                 [org.lwjgl.lwjgl/lwjgl-platform "2.9.1"
                  :classifier "natives-windows"
                  :native-prefix ""]]
  :plugins [[configleaf "0.4.6"]]
  :hooks [configleaf.hooks]
  :main pandora.core)
