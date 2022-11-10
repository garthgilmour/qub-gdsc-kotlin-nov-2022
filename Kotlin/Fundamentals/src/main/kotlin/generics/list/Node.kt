package generics.list

class Node<T>(var next: Node<T>?, var previous: Node<T>?, val payload: T)