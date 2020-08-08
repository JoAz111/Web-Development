import fresh_tomatoes
import media

toy_story = media.Movie("Toy Story", "A story of a boy and his toys that " +
                        "come to life",
                        "https://upload.wikimedia.org/wikipedia/" +
                        "en/1/13/Toy_Story.jpg",
                        "https://www.youtube.com/watch?v=CxwTLktovTU")

avatar = media.Movie("Avatar", "A marine on an alien planet",
                     "https://images-na.ssl-images-amazon.com/" +
                     "images/I/91FKuRPgwCL._AC_SL1500_.jpg",
                     "https://www.youtube.com/watch?v=6ziBFh3V1aM")

four_lions = media.Movie("Four Lions", "Four jihadis in britain get into" +
                         " trouble cause theyre dumb.", "shorturl.at/nKLP2",
                         "https://www.youtube.com/watch?v=Ew-SrlQ9tlI")

movies = [toy_story, avatar, four_lions]

fresh_tomatoes.open_movies_page(movies)
