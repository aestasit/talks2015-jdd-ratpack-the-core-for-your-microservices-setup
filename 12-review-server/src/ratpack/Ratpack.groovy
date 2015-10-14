import com.fasterxml.jackson.databind.JsonNode

import static ratpack.groovy.Groovy.ratpack
import static ratpack.jackson.Jackson.json

ratpack {
  bindings {
  }
  handlers {
    get('score/:itemId') {
      // TODO: implement data storage call here 
      render json(itemId: pathTokens['itemID'], score: new Random().nextDouble() + 4)
    }
    post('review/:itemId') {
      // TODO: implement data storage call here 
      render json(message: 'OK')
    }
    get {
      response.send "Review API"
    }
  }
}
