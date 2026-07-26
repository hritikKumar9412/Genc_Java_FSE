import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {

    test("should return repository names for techiesyed", async () => {

        const mockData = [

            {
                id: 1,
                name: "React-App"
            },

            {
                id: 2,
                name: "Node-App"
            }

        ];

        axios.get.mockResolvedValue({

            data: mockData

        });

        const repositories =
            await GitClient.getRepositories("techiesyed");

        expect(repositories).toEqual(mockData);

        expect(axios.get).toHaveBeenCalledWith(
            "https://api.github.com/users/techiesyed/repos"
        );

    });

});