(ns pandora.opengl
  (:require [pandora.core :as core])
  (:import (org.lwjgl.opengl Display DisplayMode)
           (org.lwjgl Sys)))

(defn get-time []
  (-> (Sys/getTime) (* 1000) (/ (Sys/getTimerResolution))))

(defn second-has-passed? [last]
  (> (- (get-time) last) 1000))

(defn render-scene [s w h]
  (do
    (core/initialize)
    (Display/setDisplayMode (DisplayMode. w h))
    (Display/create)
    (loop [fps 0
           last-tp (get-time)]
      (if (Display/isCloseRequested)
        nil
        (let [at-time-point (second-has-passed? last-tp)
              next-fps (if at-time-point 0 (+ fps 1))
              next-tp (if at-time-point (+ last-tp 1000) last-tp)]
          (if at-time-point (Display/setTitle (str "FPS: " fps)))
          (Display/update)
          (Display/sync 60)
          (recur next-fps next-tp))))
    (Display/destroy)))
