import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails({ cohort }) {

    return (

        <div className={styles.box}>

            <h2>{cohort.name}</h2>

            <h3
                style={{
                    color:
                        cohort.status === "ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {cohort.status}
            </h3>

            <dl>

                <dt>Coach</dt>
                <dd>{cohort.coach}</dd>

                <dt>Trainer</dt>
                <dd>{cohort.trainer}</dd>

                <dt>Start Date</dt>
                <dd>{cohort.startDate}</dd>

                <dt>Current Week</dt>
                <dd>{cohort.currentWeek}</dd>

            </dl>

        </div>

    );
}

export default CohortDetails;