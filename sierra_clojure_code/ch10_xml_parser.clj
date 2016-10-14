;;; ch10_xml_parser.clj

;; Luke Vanderhart and Stuart Sierra 
;; Practical Clojure

;; Copyright (c) 2010 by Luke Vanderhart and Stuart Sierra


;;; Example SAX Parser Using proxy (pages 150-151)

(import '(javax.xml.parsers SAXParserFactory)
        '(org.xml.sax ContentHandler)
        '(org.xml.sax.ext DefaultHandler2)
        '(java.io File))

(defn proxy-handler []
  (proxy [DefaultHandler2]
    [] ;; DefaultHandler2 constructor takes no args
    (characters [ch start length]
       (println (String. ch start length)))))

(defn extract-text [filename]
  (let [parser (.newSAXParser (SAXParserFactory/newInstance))]
    (.parse parser (File. filename) (proxy-handler))))
