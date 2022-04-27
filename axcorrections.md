## Allen's 2020 MC Corrections

**Question 15**

![Question 15](https://cdn.discordapp.com/attachments/593331093130838016/968894243605205052/unknown.png)
![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968894691070332998/unknown.png)
- **Thought process:** I originally thought that the random number generator was between 0 and 1, and since a is added to a multiple of it, the range would be a to 2a
- **Why I was wrong:** Random returns 0 (inclusive) to 1 (exclusive), which means the range is from a to 2a-1 rather than a to 2a
 
 **Question 19**
 
 ![Quesiton 19](https://cdn.discordapp.com/attachments/593331093130838016/968896002994110464/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968896039144792084/unknown.png)
 - **Thought process:** I thought the loop would result in the doubling of the row values rather than the column values
 - **Why I was wrong:** I mixed up the J and K, and the column should actually be doubled rather than the row
 
 **Question 21**
 
 ![Question 21](https://cdn.discordapp.com/attachments/593331093130838016/968896814822600744/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968896871537979402/unknown.png)
- **Thought process:** Was mainly just lost on this question and guessed
- **Why I was wrong:** Method assigns shortest string, which in this case in of, and then assigns arr[3] at the end which would be spring

 **Question 22**
 
 - Same prompt as before
 - ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968900076011388928/unknown.png)
 - **Thought process:** Assumed that the algorithm iterated through the whole list which is 6 elements
 - **Why I was wrong:** Line 12 executes each time sm is updated, which totals out to 4 times
 
 **Question 26**
 
 ![Question](https://cdn.discordapp.com/attachments/593331093130838016/968900741500653608/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968900919859228702/unknown.png)
 - **Thought process:** I assumed that the outside loops for sesgemtn II acted as j < m and k <= n, which was wrong
 - **Why I was wrong:** Outerloop happens m times, innerloop happens n-1 times, and A ends up having more iterations compared to B
 
 **Question 28**
 
 ![Question](https://cdn.discordapp.com/attachments/593331093130838016/968901717888487444/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968901879033630760/unknown.png)
 - **Thought process:** Wasn't too sure on this questino, kind of forgot about substring
 - **Why I was wrong:** abMethod(String a, String b) removes overlapping occurances, resulting in an output of si the so
 
 **Question 30**
 
 ![Question](https://cdn.discordapp.com/attachments/593331093130838016/968903250390683648/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968903432528347216/unknown.png)
 - **Thought process:** Since square needs equal side and height, setting both to x would fulfill that purpose
 - **Why I was wrong:** super(x) applies to a ingle parameter and sets both height and with to x without causing an error
 
 **Question 33**
 
 ![Question](https://cdn.discordapp.com/attachments/593331093130838016/968904455036735549/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968904489081897020/unknown.png)
 - **Thought process:** Assumed that the loops would be decreasing which would lead to a decreasing pattern
 - **Why I was wrong:** Each loop does a whole traversal resulting in the subsequent column row pattern of 2x3
 
 **Question 38**
 
 ![Question](https://cdn.discordapp.com/attachments/593331093130838016/968905095037218826/unknown.png)
 ![Answer](https://cdn.discordapp.com/attachments/593331093130838016/968905138393722950/unknown.png)
 - **Thought process:** The loop traverses through the valueList array for all 3 sections and create a working getTotal method
 - **Why I was wrong:** Option 3 creates a compilation error since getNum needs a dot operator, cannot just pass object reference
                                                    

