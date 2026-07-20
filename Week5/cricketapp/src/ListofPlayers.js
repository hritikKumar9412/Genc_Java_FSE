import React from "react";

function ListofPlayers() {

    const players = [

        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 80 },
        { name: "KL Rahul", score: 68 },
        { name: "Shubman Gill", score: 75 },
        { name: "Hardik Pandya", score: 55 },
        { name: "Ravindra Jadeja", score: 60 },
        { name: "Rishabh Pant", score: 88 },
        { name: "Suryakumar Yadav", score: 92 },
        { name: "Mohammed Shami", score: 40 },
        { name: "Jasprit Bumrah", score: 65 },
        { name: "Kuldeep Yadav", score: 72 }

    ];

    const below70 = players.filter(player => player.score < 70);

    return (

        <div>

            <h2>List of Players</h2>

            <table border="1" cellPadding="8">

                <thead>

                    <tr>
                        <th>Name</th>
                        <th>Score</th>
                    </tr>

                </thead>

                <tbody>

                    {players.map((player, index) => (

                        <tr key={index}>
                            <td>{player.name}</td>
                            <td>{player.score}</td>
                        </tr>

                    ))}

                </tbody>

            </table>

            <h2>Players with Score Below 70</h2>

            <ul>

                {below70.map((player, index) => (

                    <li key={index}>
                        {player.name} - {player.score}
                    </li>

                ))}

            </ul>

        </div>

    );

}

export default ListofPlayers;