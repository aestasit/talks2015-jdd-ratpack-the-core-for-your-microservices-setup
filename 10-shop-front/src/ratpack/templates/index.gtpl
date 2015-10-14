yieldUnescaped '<!DOCTYPE html>'
html {
  head {
    meta(charset:'utf-8')
    title("Ratpack: $title")

    meta(name: 'apple-mobile-web-app-title', content: 'Ratpack')
    meta(name: 'description', content: '')
    meta(name: 'viewport', content: 'width=device-width, initial-scale=1')

    link(href: '/favicon.ico', rel: 'shortcut icon')
    link(href: '/style.css', rel: 'stylesheet', type: 'text/css')
    link(href: 'http://fonts.googleapis.com/css?family=Oswald', rel: 'stylesheet', type: 'text/css')
  }
  body {
    h1('GROOVY BOOKS', class: "title")
    div(id: 'container') {
      books.each { book ->
        div(class: book.title.contains('Action') ? 'pricetabmid' : 'pricetab' ) {
          h1(book.title)
          div(class: 'price') {
            h2("${book.score}")
          }
          div(class: 'infos') {
            h3 {
              img(src: "${book.id}.jpg", width: 80, height: 100)
            }
            h3(book.description.take(100) + '...')
          }
          div(class: 'pricefooter') {
            div(class: 'button') {
              a('Order', href: "/order/${book.id}")
            }
          }
        }
      }
    }
  }
}
