Revise generic stack

rewrite generic stack to use an array rather than an arrayList

you should check the array size before adding a new item.
    --> if the array is full
        --> create a new array that doubles the size of the current array
        --> copy the contents of the current array to the new array