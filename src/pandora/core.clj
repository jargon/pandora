(ns pandora.core
  (:require [cfg.current :as cfg])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))

(defn- lwjgl? [[libspec & _ :as dep]]
  (.endsWith (str libspec) "lwjgl"))

(defn- lwjgl-version [project]
  (let [[libspec version & opts] (first (filter lwjgl? (:dependencies project)))]
    version))

(def initialized (atom false))

(defn initialize []
  (if-not @initialized
    (do
      (println "pandora: initializing pandora scene graph" (:version cfg/project))
      (println "pandora: with lwjgl" (lwjgl-version cfg/project))
      (reset! initialized true))))

