<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<%
    // Initialize necessary objects and variables
    HttpSession userSession = request.getSession(false);
    String currentUser = (String) (userSession != null ? userSession.getAttribute("username") : null);
    // Set the current user attribute for use in the JSP code
    pageContext.setAttribute("currentUser", currentUser);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PitStop Manager - Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <nav class="navbar">
        <div class="logo">🏁 PitStop Manager</div>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/home.jsp" class="active">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/drivers.jsp">Drivers</a></li>
            <li><a href="${pageContext.request.contextPath}/teams.jsp">Teams</a></li>
            <li><a href="${pageContext.request.contextPath}/contracts.jsp">Contracts</a></li>
            <li><a href="${pageContext.request.contextPath}/profile.jsp">Profile</a></li>
            <li>
                <%
                    if (currentUser != null && !currentUser.isEmpty()) {
                %>
                    <form action="${pageContext.request.contextPath}/logout" method="post">
                        <input type="submit" value="Logout" />
                    </form>
                <%
                    } else {
                %>
                    <form action="${pageContext.request.contextPath}/login" method="get">
                        <input type="submit" value="Login" />
                    </form>
                <%
                    }
                %>
            </li>
        </ul>
    </nav>
    <div class="home-container">
        <header class="header">
            <h1>🏁 PitStop Manager</h1>
            <p>Welcome to the Formula Racing Management Dashboard</p>
        </header>
        <section class="data-section">
            <div class="data-card">
                <h2>Driver Analysis</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Driver Name</th>
                            <th>Age</th>
                            <th>Market Value</th>
                            <th>Race Wins</th>
                            <th>Points Scored</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Max Verstappen</td>
                            <td>25</td>
                            <td>$50M</td>
                            <td>35</td>
                            <td>400</td>
                        </tr>
                        <tr>
                            <td>Lewis Hamilton</td>
                            <td>38</td>
                            <td>$60M</td>
                            <td>103</td>
                            <td>387</td>
                        </tr>
                        <tr>
                            <td>Charles Leclerc</td>
                            <td>25</td>
                            <td>$40M</td>
                            <td>5</td>
                            <td>250</td>
                        </tr>
                        <tr>
                            <td>Sergio Perez</td>
                            <td>33</td>
                            <td>$30M</td>
                            <td>6</td>
                            <td>280</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="data-card">
                <h2>Team Analysis</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Team Name</th>
                            <th>Principal</th>
                            <th>Base Location</th>
                            <th>Budget</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Red Bull Racing</td>
                            <td>Christian Horner</td>
                            <td>Milton Keynes</td>
                            <td>$500M</td>
                        </tr>
                        <tr>
                            <td>Mercedes AMG</td>
                            <td>Toto Wolff</td>
                            <td>Brackley</td>
                            <td>$450M</td>
                        </tr>
                        <tr>
                            <td>Ferrari</td>
                            <td>Fred Vasseur</td>
                            <td>Maranello</td>
                            <td>$400M</td>
                        </tr>
                        <tr>
                            <td>McLaren</td>
                            <td>Andrea Stella</td>
                            <td>Woking</td>
                            <td>$350M</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="graph-section">
            <div class="graph-card">
                <h2>Race Wins by Driver</h2>
                <canvas id="raceWinsChart"></canvas>
            </div>
            <div class="graph-card">
                <h2>Points Scored by Team</h2>
                <div class="pie-chart-container">
                    <canvas id="teamPointsChart"></canvas>
                </div>
            </div>
        </section>
    </div>
    <footer class="footer">
        <p>&copy; 2023 PitStop Manager. All rights reserved.</p>
    </footer>
    <script>
        const raceWinsCtx = document.getElementById('raceWinsChart').getContext('2d');
        new Chart(raceWinsCtx, {
            type: 'bar',
            data: {
                labels: ['Max Verstappen', 'Lewis Hamilton', 'Charles Leclerc', 'Sergio Perez'],
                datasets: [{
                    label: 'Race Wins',
                    data: [35, 103, 5, 6],
                    backgroundColor: ['#ff0000', '#00ff00', '#0000ff', '#ffcc00']
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { display: false }
                }
            }
        });

        const teamPointsCtx = document.getElementById('teamPointsChart').getContext('2d');
        new Chart(teamPointsCtx, {
            type: 'pie',
            data: {
                labels: ['Red Bull Racing', 'Mercedes AMG', 'Ferrari', 'McLaren'],
                datasets: [{
                    label: 'Points Scored',
                    data: [700, 650, 500, 400],
                    backgroundColor: ['#ff0000', '#ffffff', '#000000', '#ffcc00']
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { position: 'bottom' }
                }
            }
        });
    </script>
</body>
</html>
