(ns pandora.scene
  (:import (clojure.lang Sequential)))

(defprotocol Scene
  (draw [s]))


;; First we teach Clojure to draw en empty scene (by doing nothing)
(extend-protocol Scene
  nil
  (draw [s]
        nil))

;; Then we teach it to draw a sequence of scenes
(defn- seq-draw
  "Draw a sequence of scenes onto the current OpenGL context"
  [s]
  (loop [coll s]
    (if-let [scene (first coll)]
      (do
        (draw scene)
        (recur (rest coll))))))

(extend-protocol Scene
  Sequential
  (draw [s]
        (seq-draw s)))


