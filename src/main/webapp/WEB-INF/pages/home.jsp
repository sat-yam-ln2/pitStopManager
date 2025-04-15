body, html {
    margin: 0;
    padding: 0;
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(135deg, rgba(0, 0, 0, 0.8), rgba(50, 50, 50, 0.8));
    color: white;
    height: 100vh;
    overflow-x: hidden;
}

.background {
    background: url('login_bg.png') no-repeat center center/cover;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.login-container {
    background: rgba(255, 255, 255, 0.9);
    padding: 20px 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    text-align: center;
    width: 300px;
}

.login-container h1 {
    font-size: 24px;
    margin-bottom: 20px;
}

.login-container label {
    display: block;
    text-align: left;
    margin-bottom: 5px;
    font-size: 14px;
    color: #333;
}

.login-container input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}

.login-btn {
    background-color: black;
    color: white;
    border: none;
    padding: 10px;
    width: 100%;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
}

.login-btn:hover {
    background-color: #333;
}

.register-link {
    margin-top: 10px;
    font-size: 14px;
}

.register-link a {
    color: black;
    text-decoration: none;
    font-weight: bold;
}

.register-link a:hover {
    text-decoration: underline;
}

.signup-container {
    display: flex;
    height: 100vh;
    background-color: #f0f0f0;
}

.signup-left {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #d9d9d9;
}

.signup-left img {
    max-width: 80%;
    height: auto;
}

.signup-right {
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: #ffffff;
    padding: 40px;
}

.signup-right h1 {
    font-size: 32px;
    margin-bottom: 20px;
    font-weight: bold;
}

.signup-right form {
    width: 100%;
    max-width: 400px;
}

.signup-right label {
    display: block;
    margin-bottom: 5px;
    font-size: 14px;
    color: #333;
}

.signup-right input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}

.signup-btn {
    background-color: black;
    color: white;
    border: none;
    padding: 10px;
    width: 100%;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
}

.signup-btn:hover {
    background-color: #333;
}

.home-container {
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
}

.header {
    text-align: center;
    margin-bottom: 30px;
}

.header h1 {
    font-size: 36px;
    color: #ff0000;
    text-shadow: 0 2px 5px rgba(0, 0, 0, 0.5);
}

.header p {
    font-size: 18px;
    color: rgba(255, 255, 255, 0.8);
}

.data-section {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
    width: 100%;
}

.data-card {
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(15px);
    border: 1px solid rgba(255, 255, 255, 0.2);
    border-left: 5px solid #ff0000; /* Formula 1 red accent */
    border-radius: 10px;
    padding: 20px;
    width: 45%;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.data-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.5);
}

.data-card h2 {
    font-size: 24px;
    margin-bottom: 15px;
    color: #ffcc00;
}

table {
    width: 100%;
    border-collapse: collapse;
    color: white;
}

table th, table td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

table th {
    color: #ff0000;
    font-weight: bold;
}

table tr:hover {
    background: rgba(255, 255, 255, 0.1);
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 15px 30px;
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(10px);
    border-bottom: 1px solid rgba(255, 255, 255, 0.2);
    position: sticky;
    top: 0;
    z-index: 1000;
}

.navbar .logo {
    font-size: 28px;
    font-weight: bold;
    color: #ff0000; /* Formula 1 red */
}

.nav-links {
    list-style: none;
    display: flex;
    gap: 20px;
}

.nav-links li {
    display: inline;
}

.nav-links a {
    text-decoration: none;
    color: white;
    font-size: 16px;
    padding: 8px 15px;
    border-radius: 5px;
    transition: background-color 0.3s, color 0.3s;
}

.nav-links a:hover, .nav-links a.active {
    background-color: rgba(255, 0, 0, 0.7);
    color: white;
}

.footer {
    text-align: center;
    padding: 15px 20px;
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(10px);
    border-top: 1px solid rgba(255, 255, 255, 0.2);
    color: rgba(255, 255, 255, 0.8);
    font-size: 14px;
    box-shadow: 0 -4px 10px rgba(0, 0, 0, 0.5);
}

.graph-section {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
    width: 100%;
    margin-top: 20px;
}

.graph-card {
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(15px);
    border: 1px solid rgba(255, 255, 255, 0.2);
    border-radius: 10px;
    padding: 20px;
    width: 45%;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    text-align: center;
}

.graph-card h2 {
    font-size: 24px;
    margin-bottom: 15px;
    color: #ffcc00;
}

canvas {
    max-width: 100%;
    height: auto;
}

.pie-chart-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    max-width: 300px;
    margin: 0 auto;
    padding: 10px;
    background: rgba(0, 0, 0, 0.8);
    border-radius: 50%;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
}
