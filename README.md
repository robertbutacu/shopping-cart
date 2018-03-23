# shopping-cart
What could've been done better:
1. BasketPrice is rather useless and can be removed => 
          in the Currency trait, have a method called toPound and work with that on the foldRight
          
2. On checkoutWithOffer() ( better name maybe checkoutWithDiscount() ) have 2 functions 
      => one that applies the discount and the other that is already implemented - checkout 
      => the code would be more readeable
3. Apply discount is wrong -> one solution would be to create a Stream of x * eligibleNumberForItems + x * itemsForFree.
          => Next, take from the Stream while the amount is less than the input amount, then subtract from the input amount the length of the resulting Stream * itemsForFree - and that's the quantity of items that are to be paid. 
