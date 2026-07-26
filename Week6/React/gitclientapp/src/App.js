import React, { useEffect, useState } from "react";
import GitClient from "./GitClient";

function App() {

    const [repos, setRepos] = useState([]);

    useEffect(() => {

        GitClient.getRepositories("techiesyed")
            .then((data) => setRepos(data));

    }, []);

    return (

        <div>

            <h2>GitHub Repositories</h2>

            <ul>

                {repos.map((repo) => (

                    <li key={repo.id}>
                        {repo.name}
                    </li>

                ))}

            </ul>

        </div>

    );

}

export default App;