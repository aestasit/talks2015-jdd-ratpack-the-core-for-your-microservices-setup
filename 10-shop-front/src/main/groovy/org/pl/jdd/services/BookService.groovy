package org.pl.jdd.services

import groovy.transform.Memoized

class BookService {

  @Memoized
  List<Book> getCatalog() {
    new File('src/ratpack/data/books.csv').readLines().collect { String line ->
      new Book(
        [
          ['id', 'title', 'description'],
          line.split(';').toList()
        ].transpose().collectEntries { it } +
        [ price: new Random().nextInt(40)]
      )
    }
  }

}
