/**
 * Parses unified patch into distinct files.
 */
var PatchParser;
(function (PatchParser) {
    /**
     * Encapsulation of a single file in the patch.
     */
    var FilePatch = (function () {
        /**
         * Constructor.
         * @param path Path of the file.
         * @param content Unified diff of the file.
         */
        function FilePatch(path, content) {
            this.path = path;
            this.content = content;
        }
        return FilePatch;
    }());
    PatchParser.FilePatch = FilePatch;
    /**
     * Parses a unified patch into distinct files.
     * @param patch String representation of the unified patch.
     * @returns {FilePatch[]} An array of distinct files.
     */
    function parsePatch(patch) {
        var filePatches = new Array();
        // Split the patch content into lines by new-line characters
        var lines = patch.match(/([^\r\n]*(?:\r?\n)|[^\r\n]+)/g);
        var currFilePatch = null;
        for (var i = 0; i < lines.length; i++) {
            var line = lines[i];
            // A line starting with "+++" starts a new file diff
            if (line.indexOf("+++") == 0) {
                // e.g. +++ b/public/javascripts/app.js
                var addFileParts = line.split(/\s/);
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
    PatchParser.parsePatch = parsePatch;
})(PatchParser || (PatchParser = {}));
//# sourceMappingURL=patchparser.js.map