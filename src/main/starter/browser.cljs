(ns starter.browser
  (:require [reagent.core :as reagent]
            [reagent.dom :as dom]))

(defn simple-form []
  (let [name (reagent/atom "")]
    (fn []
      [:div
       [:label "Your Name: "]
       [:input {:type "text" 
                :placeholder "Enter your name here" 
                :value @name
                :on-change #(reset! name (-> % .-target .-value))}]
       [:button {:on-click #(js/alert (str @name "が入力されました"))} "Submit"]])))

(defn ^:dev/after-load start []
  (dom/render [simple-form] (.getElementById js/document "app")))

(defn init []
  (js/console.log "init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))


