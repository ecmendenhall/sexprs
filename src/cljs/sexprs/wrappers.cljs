(ns sexprs.wrappers  
  (:use-macros [s-express.macros :only [js-alias]]))

;;;;;;;;;;;;;;;;;;;
;; Application
;;;;;;;;;;;;;;;;;;;

(js-alias 
  "app.set(name, value)
   res.set(field, [value])" 
  set set!)

(js-alias
  "app.get(name)
   res.get(field)"
  get)

(js-alias
  "app.enable(name)"
  enable)

(js-alias
  "app.disable(name)"
  disable)

(js-alias
  "app.enabled(name)"
  enabled)

(js-alias
  "app.disabled(name)"
  disabled)

(js-alias
  "app.configure([env], callback)"
  configure)

(js-alias
  "app.use([path], function)"
  use)

;; TK: settings

(js-alias
  "app.engine(ext, callback)"
  engine)

(js-alias
  "app.param([name], callback)"
  param)

(js-alias
  "app.get(path, [callback...], callback)"
  get GET)

(js-alias
  "app.head(path, [callback...], callback)"
  head HEAD)

(js-alias
  "app.post(path, [callback...], callback)"
  post POST)

(js-alias
  "app.put(path, [callback...], callback)"
  put PUT)

(js-alias
  "app.delete(path, [callback...], callback)"
  (delete DELETE))

(js-alias
  "app.trace(path, [callback...], callback)"
  trace TRACE)

(js-alias
  "app.options(path, [callback...], callback)"
  options OPTIONS)

(js-alias
  "app.connect(path, [callback...], callback)"
  connect CONNECT)

(js-alias
  "app.patch(path, [callback...], callback)"
  patch PATCH)

(js-alias
  "app.all(path, [callback...], callback)"
  all)

(js-alias
  "app.locals"
  locals)

(js-alias
  "app.render(view, [options], callback)
   res.render(view,  [locals], callback)"
  render)

;; TK: app.routes

(js-alias
  "app.listen()"
  listen)

;;;;;;;;;;;;;;;;;;;
;; Request
;;;;;;;;;;;;;;;;;;;

;; TK: req.params
;;
;; TK: req.query
;;
;; TK: req.body
;;
;; TK: req.files

(js-alias
  "req.param(name)"
  param)

;; TK: req.route
;;
;; TK: req.cookies
;;
;; TK: req.signedCookies

(js-alias
  "req.get(field)"
  get)

(js-alias
  "req.accepts(types)"
  accepts)

;; TK: req.accepted

(js-alias
  "req.is(type)"
  is)

;; TK: req.ip
;;
;; TK: req.ips
;;
;; TK: req.path
;;
;; TK: req.fresh
;;
;; TK: req.stale
;;
;; TK: req.xhr
;;
;; TK: req.protocol
;;
;; TK: req.secure
;;
;; TK: req.subdomains
;;
;; TK: req.originalUrl
;;
;; TK: req.acceptedLanguages
;;
;; TK: req.acceptedCharsets

(js-alias
  "req.acceptsCharset(charset)"
  acceptsCharset accepts-charset)

(js-alias
  "req.acceptsLanguage(lang)"
  acceptsLanguage accepts-language)

;; Response

(js-alias
  "res.status(code)"
  status)

(js-alias
  "res.cookie(name, value, [options])"
  cookie)

(js-alias
  "res.clearCookie(name, [options])"
  clearCookie clear-cookie)

(js-alias
  "res.redirect([status], url)"
  redirect)

;; TK: res.location
;; TK: res.charset

(js-alias
  "res.send([body|status], [body])"
  send)

(js-alias
  "res.json([status|body], [body])"
  json)

(js-alias
  "res.jsonp([status|body], [body])"
  jsonp)

(js-alias
  "res.type(type)"
  type)

(js-alias
  "res.format(object)"
  format)

(js-alias
  "res.attachment([filename])"
  attachment)

(js-alias
  "res.sendfile(path, [options], [fn])"
  sendfile)

(js-alias
  "res.download(path, [filename], [fn])"
  download)

(js-alias
  "res.links(links)"
  links)

;; TK: res.locals

;;;;;;;;;;;;;;;;;;;
;; Middleware
;;;;;;;;;;;;;;;;;;;

(js-alias 
  "basicAuth()"
  basicAuth basic-auth)

(js-alias
  "bodyParser()"
  bodyParser body-parser)

(js-alias
  "compress()"
  compress)

(js-alias
  "cookieParser"
  cookieParser cookie-parser)

(js-alias
  "cookieSession()"
  cookieSession cookie-session)

(js-alias
  "csrf()"
  csrf)

(js-alias
  "directory()"
  directory)
