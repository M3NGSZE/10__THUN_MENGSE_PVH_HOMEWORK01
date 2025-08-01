val productNames: List<String> = listOf(
    "Laptop",
    "Mouse",
    "Keyboard",
    "Monitor",
    "Webcam",
    "Wireless Charger",
    "USB Hub",
    "Headphones",
    "External Hard Drive",
    "Smartphone",
    "Tablet",
    "Bluetooth Speaker",
    "Printer",
    "Graphics Card",
    "Desk Lamp",
    "Office Chair",
    "Microphone"
)

val productPrices: List<Double> = listOf(
    999.99,  // Laptop
    25.50,   // Mouse
    45.40,   // Keyboard
    189.99,  // Monitor
    49.99,   // Webcam
    29.99,   // Wireless Charger
    15.00,   // USB Hub
    89.99,   // Headphones
    79.50,   // External Hard Drive
    699.99,  // Smartphone
    399.99,  // Tablet
    59.99,   // Bluetooth Speaker
    149.99,  // Printer
    349.99,  // Graphics Card
    24.99,   // Desk Lamp
    129.99,  // Office Chair
    25.99    // Microphone
)

var totalCoast = 0.0

fun main(){

    var index = 0
//    val indexName = productNames.size
//    val indexPrice = productNames.size
//    println(indexName)
//    println(indexPrice)

    while (index < productNames.size || index < productPrices.size){
        println(productNames[index])
        index++
    }

    for ((index, item) in productNames.withIndex()) println("${index+1}. $item - $${productPrices.get(index)}")

    productNames.forEachIndexed { index, item -> println("${index+1}. $item - $${productPrices.get(index)}") }

}