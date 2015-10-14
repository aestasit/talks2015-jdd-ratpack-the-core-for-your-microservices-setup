@Grab("io.ratpack:ratpack-groovy:1.0.0")
@Grab("com.fasterxml.jackson.core:jackson-annotations:2.6.2")
import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {
    get {
      response.send "Time on JDD is " + new Date().toString() 
    }
  }
}


