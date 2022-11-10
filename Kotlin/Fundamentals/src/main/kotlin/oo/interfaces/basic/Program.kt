package oo.interfaces.basic

interface Transaction {
    val timeout: Int
    var retries: Int
    fun start()
    fun commit()
    fun rollback()
}

class MySQLTransaction(override var retries: Int) : Transaction {
    override val timeout: Int
        get() = 3000

    override fun start() = println("MySQL transaction started")
    override fun commit() = println("MySQL transaction committed")
    override fun rollback() = println("MySQL transaction rolled back")
}

class PostgreSQLTransaction(override var retries: Int) : Transaction {
    override val timeout: Int
        get() = 4000

    override fun start() = println("PostgreSQL transaction started")
    override fun commit() = println("PostgreSQL transaction committed")
    override fun rollback() = println("PostgreSQL transaction rolled back")
}

fun main() {
    fun useTransaction(t: Transaction) {
        println("Timeout is ${t.timeout / 1000} seconds")
        println("Number of retries is ${t.retries}")
        t.start()
        t.commit()
    }

    val t1 = MySQLTransaction(7)
    val t2 = PostgreSQLTransaction(9)
    useTransaction(t1)
    useTransaction(t2)
}
