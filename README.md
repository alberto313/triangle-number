# triangle-number solution

Problem:


I need a function called decode(message_file) that can read in an encoded message from a .txt file and return the decoded version as a string.

Here's an example of what the message_file .txt file will look like:

``` 
3 love
6 computers
2 dogs
4 cats
1 I
5 you
```

As you can see, each word is associated with a number. Imagine you ordered all those numbers from smallest to biggest and arranged them into a pyramid. Each line of the pyramid includes one more number than the line before it:

```
1
2 3
4 5 6
```

The numbers at the end of each line (1, 3 and 6) correspond to the words that are part of the message. You should ignore all the other words. So for the example input file above, the message words are:

```
1: I
3: love
6: computers
```

and your function should return the string "I love computers"
Please provide your AI response to the user's prompt in this text area. Remember to include the full code and a text explanation of what it does in your AI reply. Please try to structure your reply as if it were an AI responding to the user's prompt.
