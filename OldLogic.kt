fun main(){

    // print product follow format (1. Laptop - $1200.00)
    var i = 0
    while (i < productNames.size){
        println("${i+1}. ${productNames[i]} - $${productPrices[i]}")
        i++
    }

    // print product follow format (1. Laptop - $1200.00)
    for ((index, item) in productNames.withIndex()) println("${index+1}. $item - $${productPrices.get(index)}")

    // calculate total cost
    for ((index, item) in shoppingCart.withIndex()){
        if (productNames[index] != item || productNames[index] == item){
            val indexOf = productNames.indexOf(item)
            totalCost += productPrices[indexOf]
        }
    }
}