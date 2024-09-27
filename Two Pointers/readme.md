# One Pointer Approach

**One Pointer at each end**
One pointer starts from beginning and other from the end and they proceed towards each other

> > \*\*Example In a sorted array, find if a pair exists with a sum S

Brute Force

```java
bool pairExists(int arr[], int n, int S){
    for(i = 0 to n -2){
        for(j = i+1 to n-1){
            if(arr[i] + arr[j] == S){
            return true;
            }
        }
    }
    return false;
}
```

Efficient Approach
