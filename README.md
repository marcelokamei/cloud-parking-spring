# cloud Parking

## Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=kamei -d postgres:10-alpine