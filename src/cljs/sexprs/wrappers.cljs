(ns sexprs.wrappers  
  (:use-macros [sexprs.macros :only [js-alias js-property]]))

(declare signedCookies)
(declare originalUrl)
(declare acceptedLanguages)
(declare acceptedCharsets)

;;;;;;;;;;;;;;;;;;;
;; Application
;;;;;;;;;;;;;;;;;;;

(defn express []
  (let [express (js/require "express")]
    (express)))

;; FIXME: http://bit.ly/WTaL5g
;(defn static [directory]
;  (let [express (js/require "express")]
;  (.static express (str js/__dirname directory))))

(js-alias 
  "app.set(name, value)
   res.set(field, [value])" 
  set set-value)

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
  use use-middleware)

(js-property
  "app.settings"
  settings)

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

;(js-alias
;  "app.delete(path, [callback...], callback)"
;  delete DELETE)

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

(js-property
  "app.locals"
  locals)

(js-alias
  "app.render(view, [options], callback)
   res.render(view,  [locals], callback)"
  render)

(js-property
  "app.routes"
  routes)

(js-alias
  "app.listen()"
  listen)

;;;;;;;;;;;;;;;;;;;
;; Request
;;;;;;;;;;;;;;;;;;;

(js-property
  "req.params"
  params)

(js-property
  "req.query"
  query)

(js-property
  "req.body"
  body)

(js-property
  "req.files"
  files)

(js-alias
  "req.param(name)"
  param)

(js-property
  "req.route"
  route)

(js-property
  "req.cookies"
  cookies)

(js-property
  "req.signedCookies"
  signedCookies signed-cookies)

(js-alias
  "req.get(field)"
  get)

(js-alias
  "req.accepts(types)"
  accepts)

(js-property
  "req.accepted"
  accepted)

(js-alias
  "req.is(type)"
  is)

(js-property
  "req.ip"
  ip)

(js-property
  "req.ips"
  ips)

(js-property
  "req.path"
  path)

(js-property
  "req.fresh"
  fresh)

(js-property
  "req.stale"
  stale)

(js-property
  "req.xhr"
  xhr)

(js-property
  "req.protocol"
  protocol)

(js-property
  "req.secure"
  secure)

(js-property
  "req.subdomains"
  subdomains)

(js-property
  "req.originalUrl"
  originalUrl original-url)

(js-property
  "req.acceptedLanguages"
  acceptedLanguages accepted-languages)

(js-property
  "req.acceptedCharsets"
  acceptedCharsets accepted-charsets)

(js-alias
  "req.acceptsCharset(charset)"
  acceptsCharset accepts-charset)

(js-alias
  "req.acceptsLanguage(lang)"
  acceptsLanguage accepts-language)

;;;;;;;;;;;;;;;;;;;
;; Response
;;;;;;;;;;;;;;;;;;;

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

(js-property
  "res.location"
  location)

(js-property
  "rex.charset"
  charset)

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

(js-property
  "res.locals"
  locals)

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
