import ktor.KtorGamesDataSource
import ktor.model.mapToGame
import model.Game
import sqlDelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames().map { it.mapToGame() }
    }

    override suspend fun searchGame(query: String): List<Game> {
         return remoteDataSource.searchGame(query).map { it.mapToGame() }
    }
}