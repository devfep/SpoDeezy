[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <!-- <a href="https://github.com/devfep/SpoDeezy">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a> -->

  <h3 align="center">SpoDeezy</h3>

  <p align="center">
    A Spotify-Deezer Playlist Syncer
    <br />
        ·
    <a href="https://github.com/devfep/SpoDeezy/issues">Report Bug</a>
    ·
    <a href="https://github.com/devfep/SpoDeezy/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![SpoDeezy Screen Shot][SpoDeezy-homepage-screenshot]](https://github.com/devfep/SpoDeezy)

SpoDeezy is a fullstack web application that allows you to sync your playlists from Spotify Music to Spotify. As an add-on, you get to backup you playlists for ease of porting to Deezer (other streaming platforms).


<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With

Java, Springboot, PostgreSQL/MySQL, Docker, HTML/CSS, Bootstrap, Javascript, Thymeleaf, Spotify Web API, Deezer Web API

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* JDK 11+ 
 

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Sign up for API Keys at:<br/>
  i. [Spotify For Developers](https://developer.spotify.com/dashboard/login)
  ii. [Deezer For Developers](https://developers.deezer.com/login?redirect=/api)
2. Clone the repo
   ```sh
   git clone https://github.com/devfep/SpoDeezy.git
   ```
3. Install Maven dependencies
   ```sh
   mvn install
   ```
4. Create an enum class container your Spotify API and Deezer API credentials and reference them in the Auth controllers
   ```Auth Controllers
   API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

* Backup and share your Spotify playlists with your friends via text on SpoDeezy
[![SpoDeezy Screen Shot][SpoDeezy-dashboard-screenshot]](https://github.com/devfep/SpoDeezy)

<br/>

* Transfer your playlists to Deezer
[![SpoDeezy Screen Shot][SpoDeezy-pmc-screenshot]](https://github.com/devfep/SpoDeezy)


Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Add Docker image
- [ ] Add Changelog
- [ ] Serve as an authentication server with Keycloak
- [ ] Add Social logins


See the [open issues](https://github.com/devfep/SpoDeezy/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See [License](https://choosealicense.com/licenses/mit/) for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Felix P. - [@fepdev](https://twitter.com/fepdev) - devfep@gmail.com

Project Link: [https://github.com/devfep/SpoDeezy](https://github.com/devfep/SpoDeezy)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [MIT License](https://choosealicense.com/licenses/mit/)
* [Img Shields](https://shields.io)
* [Bootstrap Icons](https://icons.getbootstrap.com)


<p align="right">(<a href="#readme-top">back to top</a>)</p>





<!-- MARKDOWN LINKS & IMAGES -->
[linkedin-url]: https://linkedin.com/in/felixay
[SpoDeezy-homepage-screenshot]: readMeImages/SpoDeezyHomePage.png
[SpoDeezy-dashboard-screenshot]: readMeImages/Dashboard.png
[SpoDeezy-pmc-screenshot]: readMeImages/PlaylistManagementConsole.png
[contributors-shield]: https://img.shields.io/github/contributors/devfep/SpoDeezy.svg?style=for-the-badge
[contributors-url]: https://github.com/devfep/SpoDeezy/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/devfep/SpoDeezy.svg?style=for-the-badge
[forks-url]: https://github.com/devfep/SpoDeezy/network/members
[stars-shield]: https://img.shields.io/github/stars/devfep/SpoDeezy.svg?style=for-the-badge
[stars-url]: https://github.com/devfep/SpoDeezy/stargazers
[issues-shield]: https://img.shields.io/github/issues/devfep/SpoDeezy.svg?style=for-the-badge
[issues-url]: https://github.com/devfep/SpoDeezy/issues
[license-shield]: https://img.shields.io/github/license/devfep/SpoDeezy.svg?style=for-the-badge
[license-url]: https://github.com/devfep/SpoDeezy/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/felixay


