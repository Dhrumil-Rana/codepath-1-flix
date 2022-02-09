# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [x] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [x] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [x] Implement a shared element transition when user clicks into the details of a movie (1 point).
- [x] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [x] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [x] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [x] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [ ] Apply data binding for views to help remove boilerplate code. (1 point)
- [x] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF
<img src="https://i.imgur.com/1wLvDmx.gif" width=250><br>

### Notes

In order for a movie to be considered popular in my version of this app, it must have a rating of at least 8/10. I had trouble getting the rating bar to show the accurate number of stars (it was rounding), but I fixed the issue by setting the step size to 0.01. I also had an issue with the Glide transformation in the stretch story breaking the formatting of the list, but this was fixed by reducing the size of the placeholder image from Part 1 (the placeholder was previously larger than the image view size).

## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [Glide Transformations](https://github.com/wasabeef/glide-transformations) - An Android transformation library providing a variety of image transformations for Glide
- [Parcelable](https://github.com/johncarl81/parceler) - Android Parcelables made easy through code generation

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF
<img src="https://i.imgur.com/kNl0B1a.gif" width=834><br>

### Notes
I had to reinstall the app as I was making it when I got to the part where I first had to use AsyncHttpClient in order to avoid an error. It took me some time to figure out how to change the app icon and how to make the placeholder image readable to Android (converting SVG to XML). I changed the theme of the app from the default white with a purple header to a black theme.
The placeholder image was made by me. The app icon I used, ["Movie, music, player, video icon"](https://www.iconfinder.com/icons/1564536/movie_music_player_video_icon) by [Artyom Khamitov](https://www.iconfinder.com/Kh.Artyom) is licensed under [CC BY 3.0](https://creativecommons.org/licenses/by/3.0/). The app icon art is cropped from the original in different ways depending on if round or square icons are being used.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
