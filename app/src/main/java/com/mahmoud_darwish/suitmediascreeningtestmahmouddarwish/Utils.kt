package com.mahmoud_darwish.suitmediascreeningtestmahmouddarwish

fun isPalindrome(name: String): Boolean {

    var left = 0
    var right = name.lastIndex

    while (left <= right) {
        if (name[left] != name[right]) return false

        left += 1; right -= 1
    }

    return true
}

fun getPalindromeCheckerDialogMessage(string: String) =
    if (isPalindrome(string)) "The string is a palindrome"
    else "The string is not a palindrome"

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    class Success<T>(val data: T) : Resource<T>()
    class Error(val message: String) : Resource<Nothing>()
}