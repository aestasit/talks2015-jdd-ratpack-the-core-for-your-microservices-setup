import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.pl.jdd.services.Book
import org.pl.jdd.services.BookService
import ratpack.groovy.template.MarkupTemplateModule
import ratpack.http.Status
import ratpack.http.client.HttpClient
import ratpack.http.client.ReceivedResponse
import ratpack.http.client.RequestSpec

import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.*

import ratpack.exec.Blocking

ratpack {
  bindings {
    module(MarkupTemplateModule) { configuration ->
      configuration.autoNewLine = true
      configuration.useDoubleQuotes = true
      configuration.autoIndent = true
      configuration.expandEmptyElements = true
    }
    bind BookService
  }
  handlers { BookService booksService ->
    get { HttpClient client ->
      List<Book> books = booksService.catalog
      books.each { Book book ->
        client.get(new URI("http://localhost:8902/score/${book.id}".toString())).
          then { ReceivedResponse receivedResponse ->
          String bodyText = receivedResponse.body.text
          Double score = new JsonSlurper().parseText(bodyText).'score' as Double
          book.score = Math.round(score * 100) / 100
        }
      }
      render groovyMarkupTemplate("index.gtpl", title: "Groovy Book Shop", books: books)
    }
    get ('order/:bookId') { HttpClient client ->
      client.post(new URI("http://localhost:8901/order/${pathTokens['bookId']}")) { spec ->
        spec.body { b -> b.text "order data" }
      }.onError { Throwable t ->
        render json(message: 'FAIL', exception: t)
      }.then {
        render json(message: 'OK')
      }
    }
    files { dir "public" }
    files { dir "content" }
  }
}
