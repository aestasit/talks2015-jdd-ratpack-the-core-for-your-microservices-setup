yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
  head {
    meta(charset: 'utf-8')
    title(title ?: 'No Title')
    link(href: "css/style.css", rel: "stylesheet")
  }
  body {
    bodyContents()
    script(src: "http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.1/jquery.min.js")
    script(src: "http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js")
  }
}
