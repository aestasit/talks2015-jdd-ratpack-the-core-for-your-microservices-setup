package org.pl.jdd.services

import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

@Canonical
@CompileStatic
@TypeChecked
class Book {
  String id
  String title
  String description
  Double price = 10.0d
  Double score = 0.0d
}
