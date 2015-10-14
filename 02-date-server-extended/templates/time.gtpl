layout 'layout.gtpl',
title: title,
bodyContents: contents {
  div(id: 'clock', class: 'light') {
    div(class: 'display') {
      div(class: 'weekdays') {
        span('MON')
        span('TUE', class: "active")
        span('WED')
        span('THU')
        span('FRI')
        span('SAT')
        span('SUN')
      }
      div('pm', class: 'ampm')
      div(class: 'alarm')
      def digit2name = 'zero one two three four five six seven eight nine'.split(' ')     
      def digits = jddTime.replaceAll('[:\\.]', '').toList().collect { it.toInteger() }
      div(class: 'digits') {
        div(class: digit2name[digits[0]]) {
          span(class: "d1")
          span(class: "d2")
          span(class: "d3")
          span(class: "d4")
          span(class: "d5")
          span(class: "d6")
          span(class: "d7")
        }
        div(class: digit2name[digits[1]]) {
          span(class: "d1")
          span(class: "d2")
          span(class: "d3")
          span(class: "d4")
          span(class: "d5")
          span(class: "d6")
          span(class: "d7")
        }
        div(class: 'dots')
        div(class: digit2name[digits[2]]) {
          span(class: "d1")
          span(class: "d2")
          span(class: "d3")
          span(class: "d4")
          span(class: "d5")
          span(class: "d6")
          span(class: "d7")
        }
        div(class: digit2name[digits[3]]) {
          span(class: "d1")
          span(class: "d2")
          span(class: "d3")
          span(class: "d4")
          span(class: "d5")
          span(class: "d6")
          span(class: "d7")
        }
        div(class: 'dots')
        div(class: digit2name[digits[4]]) {
          span(class: "d1")
          span(class: "d2")
          span(class: "d3")
          span(class: "d4")
          span(class: "d5")
          span(class: "d6")
          span(class: "d7")
        }
        div(class: digit2name[digits[5]]) {
          span(class: "d1")
          span(class: "d2")
          span(class: "d3")
          span(class: "d4")
          span(class: "d5")
          span(class: "d6")
          span(class: "d7")
        }
      }
    }
  }
}
