
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

var totalCost = 0.0

var shoppingCart: MutableList<String> = mutableListOf()

fun main(){

//    var index = 0
//    while (index < productNames.size){
//        println("${index+1}. ${productNames[index]} - $${productPrices[index]}")
//        index++
//    }
//    for ((index, item) in productNames.withIndex()) println("${index+1}. $item - $${productPrices.get(index)}")

    println("Items List and Price\n")

    productNames.forEachIndexed { index, item -> println("${index+1}. $item - $${productPrices[index]}") }

    println("\nAdd Product to Cart\n")

    while (true){
        var found = false
        print("Enter product: ")
        val product = readln().toString().trim().lowercase()
        if (product == "done") break
        for (item in productNames){
            if (product == item.lowercase()){
                found = true
                shoppingCart.add(item)
                break
            }
        }
        if (!found){
            println("item not found\n")
        }
    }

    println("\nitem in cart: $shoppingCart")

    for ((index, item) in shoppingCart.withIndex()){
        if (productNames[index] != item || productNames[index] == item){
            val indexOf = productNames.indexOf(item)
            totalCost += productPrices[indexOf]
        }

    }

    if (shoppingCart.isEmpty()){
        println("\nProduct XYZ not found in catalog")
    }else{
        println("\nTotal Price: $$totalCost")
    }

    var finalCost = totalCost

    if (shoppingCart.contains("Headphones") && shoppingCart.contains("Microphone") && shoppingCart.contains("Laptop") && shoppingCart.contains("Mouse")){
        finalCost -= (productPrices[1] * 0.08) + 10
    }else if (shoppingCart.contains("Laptop") && shoppingCart.contains("Mouse")){
        finalCost -= productPrices[1] * 0.08
    }else if (shoppingCart.contains("Headphones") && shoppingCart.contains("Microphone")) {
        finalCost -= 10
    }

    if (finalCost > 1500.00){
        finalCost -= finalCost * 0.1
    }else if (finalCost > 500){
        finalCost -= finalCost * 0.05
    }

    if (finalCost > 0){
        print("\nTotal Cost After Discount: $$finalCost\n")
    }

    // 2.04, 10
}