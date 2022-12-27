package database

import PlatformConfiguration
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

actual class DbDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver( //TODO: There shouldn't be any parameters
        schema: SqlDriver.Schema,
        name: String
    ): SqlDriver {
        return JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    }
}