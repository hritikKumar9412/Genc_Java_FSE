import React from "react";
import CohortDetails from "./Components/CohortDetails";

function App() {

    const cohorts = [

        {
            name: "React Fundamentals",
            status: "ongoing",
            coach: "John",
            trainer: "Alice",
            startDate: "15-Jul-2026",
            currentWeek: 4
        },

        {
            name: "Java Full Stack",
            status: "completed",
            coach: "David",
            trainer: "Smith",
            startDate: "01-May-2026",
            currentWeek: 12
        }

    ];

    return (

        <div>

            {cohorts.map((cohort, index) => (

                <CohortDetails
                    key={index}
                    cohort={cohort}
                />

            ))}

        </div>

    );
}

export default App;