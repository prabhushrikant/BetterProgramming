Facade provides a single interface or api for a complex operation which involves invoking multiple system. However, once the facade api method is invoked,
the steps are always same.

Note: It might feel like a strategy pattern when read, but in case of strategy the steps within the common strategy method change depending which strategy is 
in invoked.

Example of facade method was `baseStrategy.getAds(request)` here, getAds() method provides a common facade method which has fixed steps involving a preprocess module, adgeneration module and postprocess module. However implementation of each module changes based on which strategy is used. PostProcessing module for searchPageStrategy would be different than homePageStrategy.