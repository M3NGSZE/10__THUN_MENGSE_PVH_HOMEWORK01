
val productNames: List<String> = listOf(
    "Laptop", "Mouse", "Keyboard", "Monitor", "Webcam", "Wireless Charger", "USB Hub", "Headphones",
    "External Hard Drive", "Smartphone", "Tablet", "Bluetooth Speaker", "Printer", "Graphics Card",
    "Desk Lamp", "Office Chair", "Microphone"
)

val productPrices: List<Double> = listOf(
    999.99, 25.50, 45.40, 189.99, 49.99, 29.99, 15.00, 89.99, 79.50, 699.99, 399.99, 59.99, 149.99,
    349.99, 24.99, 129.99, 25.99
)

var totalCost = 0.0

var shoppingCart: MutableList<String> = mutableListOf()

const val firstComboDis = 0.08
const val secondComboDis = 10.00
const val highDiscount = 1500.00
const val highDisTotal = 0.1
const val lowDiscount = 500.00
const val lowDisTotal = 0.05

fun main(){
    println("Items List and Price\n")

    // display products follow format (1. Laptop - $1200.00)
    productNames.forEachIndexed { index, item -> println("${index+1}. $item - $${productPrices[index]}") }

    // Add products to cart
    println("\nAdd Product to Cart\n")
    while (true){
        // prompt user input
        print("Enter product: ")
        val product = readln().trim().lowercase()
        if (product == "done") break

        // add to cart
        var found = false
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

    // display item in cart and calculate total cost
    println("\nItems in cart")
    for ((i,item) in shoppingCart.withIndex()) {
        val index = productNames.indexOf(item)      // find index of item by item name
        if (index != -1) {
            println("${i+1}. $item - $${productPrices[index]}")     // display item in cart list
            totalCost += productPrices[index]                       // sum total price by index
        }
    }

    // display total cost
    if (shoppingCart.isEmpty()){
        println("\nProduct XYZ not found in catalog")
    }else{
        val roundTotalCost = (totalCost * 100).toInt() / 100.0        // round total cost with 2 decimal
        println("\nTotal Price: $$roundTotalCost")
    }

    var finalCost = totalCost

    // first discount
    if (shoppingCart.contains("Headphones") && shoppingCart.contains("Microphone") && shoppingCart.contains("Laptop") && shoppingCart.contains("Mouse")){
        finalCost -= (productPrices[1] * firstComboDis) + secondComboDis
    }else if (shoppingCart.contains("Laptop") && shoppingCart.contains("Mouse")){
        finalCost -= productPrices[1] * firstComboDis
    }else if (shoppingCart.contains("Headphones") && shoppingCart.contains("Microphone")) {
        finalCost -= secondComboDis
    }

    // second discount
    if (finalCost > highDiscount){
        finalCost -= finalCost * highDisTotal
    }else if (finalCost > lowDiscount){
        finalCost -= finalCost * lowDisTotal
    }

    // display final cost
    if (finalCost > 0){
        val roundFinalCost = (finalCost * 100).toInt() / 100.0         // round final cost with  2 decimal
        println("\nFinal Cost: $$roundFinalCost")
    }

}