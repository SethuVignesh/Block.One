# Block.One
As an EOS user, I want to see the contents of the most recent blocks on the EOS Public Blockchain.
## Screenshots
![EOS app](app/screenshots/ezgif-3-82a1d98d96de.gif)
## Assignment checklist
 - [x] App has a button which, when clicked, will display a list of the 20 most recent blocks.
 - [x] When the user clicks on a block they should be taken to a block Details screen.
 - [x] The Details screen should show a summary view of the block which contains the producer, count of
transactions and the producer signature.
 - [x] The Details screen should have a toggle to show and hide the raw contents of the block.
 - [x] Application code is viewable publicly on GitHub.
 - [x] Screenshots of working application should be in the README.
 - [x] Application should be written in Kotlin.
 - [ ] Application should have unit tests.
 
 ## Bonus Tasks
 - [x] Query the specific keys of the user in each transaction by implementing the getAccount() method and
display the keys on that user’s account in the detail screen. The keys should be in PEM format.
 - [x] Application uses MVVM architecture
 - [x] Add infinite scrolling to the list of transactions.
 
 ## Resources
- EOS: https://github.com/EOSIO/eos
- Public Node Endpoint: https://eos.greymass.com (utilize RPC endpoints to get necessary data)
- RPC Endpoint Documentation (block contents may vary):
https://developers.eos.io/eosio-nodeos/reference
- EOSIO SDK for Java Documentation: https://github.com/EOSIO/eosio-java
