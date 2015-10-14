@Grab("io.ratpack:ratpack-groovy:1.0.0")
@Grab("com.fasterxml.jackson.core:jackson-annotations:2.6.2")
@Grab("org.slf4j:slf4j-simple:1.7.12")
import static ratpack.groovy.Groovy.ratpack

import static java.time.ZonedDateTime.now
import static java.time.ZoneId.of
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME

import static ratpack.jackson.Jackson.json

import static ratpack.groovy.Groovy.markupBuilder
import static ratpack.groovy.Groovy.groovyMarkupTemplate
import static ratpack.groovy.Groovy.groovyTemplate

import ratpack.groovy.template.MarkupTemplateModule
import ratpack.groovy.template.TextTemplateModule

ratpack {
  bindings {
    module(TextTemplateModule)
    module(MarkupTemplateModule) { configuration ->
      configuration.autoNewLine = true
      configuration.useDoubleQuotes = true
      configuration.autoIndent = true
      configuration.expandEmptyElements = true
    }
  }
  handlers { 
    get("json") {
      render json(
        response: [ 
          date: jddTime 
        ]
      )
    }
    get("xml") {
      render markupBuilder("application/xml", "UTF-8") {
        response {
          date jddTime
        }
      }
    }
    get("html") {
      render groovyMarkupTemplate("time.gtpl", title: "Time on JDD", jddTime: jddTime)
    }
    prefix("v2") {
      post {
        byContent {
          type("application/json") {
            render json(
              result: [ 
                date: jddTime,
                msg: 'hello' 
              ]
            )
          }
          xml {
            render markupBuilder("application/xml", "UTF-8") {
              result {
                date jddTime
                msg 'hello'
              }
            }
          }
          plainText {
            render groovyTemplate("result.txt", jddTime: jddTime)
          }
          noMatch {
            render "Unknown format!"
          }
        }
      }
    }
    get {
      render groovyTemplate("result.txt", jddTime: jddTime)
    }
    files { dir "assets" }
  }
}


String getJddTime() {
  now(of('Europe/Warsaw')).format(ISO_LOCAL_TIME)
}                  

