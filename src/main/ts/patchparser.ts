/**
 * Parses unified patch into distinct files.
 */
module PatchParser {

    /**
     * Encapsulation of a single file in the patch.
     */
    export class FilePatch {

        /**
         * Constructor.
         * @param path Path of the file.
         * @param content Unified diff of the file.
         */
        constructor(public path: string, public content: string) {}
    }

    /**
     * Parses a unified patch into distinct files.
     * @param patch String representation of the unified patch.
     * @returns {FilePatch[]} An array of distinct files.
     */
    export function parsePatch(patch: string): FilePatch[] {
        var filePatches: FilePatch[] = new Array<FilePatch>();
        // Split the patch content into lines by new-line characters
        var lines: string[] = patch.match(/([^\r\n]*(?:\r?\n)|[^\r\n]+)/g);
        var currFilePatch: FilePatch = null;

        for (var i: number = 0; i < lines.length; i++) {
            var line: string = lines[i];

            // A line starting with "+++" starts a new file diff
            if (line.indexOf("+++") == 0) {
                // e.g. +++ b/public/javascripts/app.js
                let addFileParts: string[] = line.split(/\s/);

                // New file line must have the file name as the second element
                if (addFileParts.length < 2 && addFileParts[1].length < 2) {
                    continue;
                }

                // Create new file
                currFilePatch = new FilePatch(addFileParts[1].substr(1), "");
                filePatches.push(currFilePatch);
            }
            else if (line.indexOf("+") == 0 || line.indexOf("-") == 0 || line.indexOf(" ") == 0 || line.indexOf("@") == 0) {
                // Sanity check
                if (!currFilePatch) {
                    continue;
                }

                // Append diff lines to the file
                currFilePatch.content += line;
            }
        }

        return filePatches;
    }
}