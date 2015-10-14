@Grapes([
  @Grab("org.gebish:geb-core:0.12.2"),
  @Grab("com.github.detro.ghostdriver:phantomjsdriver:1.1.0"),
  @Grab("org.seleniumhq.selenium:selenium-support:2.48.2")
])
import geb.Browser
import static java.time.LocalDateTime.now
 
def digit2name = 'zero one two three four five six seven eight nine'.split(' ')

Browser.drive {
  go "http://localhost:5555/html"  
  def d = $("div", class: 'digits') 
  assert digit(d, 3) == digit2name[(now().minute / 10) as int]
}

println "OK"

def digit(digits, num) {
  digits.find("div", num).first().getAttribute('class')
}