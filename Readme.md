# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

📝 `NOTE - PASTE PART 2 SNIPPET HERE:` Paste the README template for part 2 of this assignment here at the top. This will show a history of your development process, which users stories you completed and how your app looked and functioned at each step.

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [ ] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF
<img src="http://g.recordit.co/MARAolkzXr.gif" width=300><br>

### Notes
I had to reinstall the app as I was making it when I got to the part where I first had to use AsyncHttpClient in order to avoid an error. It took me some time to figure out how to change the app icon and how to make the placeholder image readable to Android (converting SVG to XML). I changed the theme of the app from the default white with a purple header to a black theme.
The placeholder image was made by me. The app icon I used, ["Movie, music, player, video icon"](https://www.iconfinder.com/icons/1564536/movie_music_player_video_icon) by [Artyom Khamitov](https://www.iconfinder.com/Kh.Artyom) is licensed under [CC BY 3.0](https://creativecommons.org/licenses/by/3.0/). The app icon art is cropped from the original in different ways depending on if round or square icons are being used.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
