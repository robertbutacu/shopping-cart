# shopping-cart
What could've been done better:
1. BasketPrice is rather useless and can be removed => 
          in the Currency trait, have a method called toPound and work with that on the foldRight
          
2. On checkoutWithOffer() ( better name maybe checkoutWithDiscount() ) have 2 functions 
      => one that applies the discount and the other that is already implemented - checkout 
      => the code would be more readeable
