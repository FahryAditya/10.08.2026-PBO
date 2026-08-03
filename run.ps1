param(
    [string]$SourceFile
)

$ErrorActionPreference = 'Stop'

$root = Split-Path -Parent $PSScriptRoot
$src = Join-Path $root 'src'
$bin = Join-Path $root 'bin'

$SourceFile = (Resolve-Path -LiteralPath $SourceFile).Path

$srcPath = (Resolve-Path -LiteralPath $src).Path
if ($SourceFile.StartsWith($srcPath, [System.StringComparison]::OrdinalIgnoreCase)) {
    $relative = $SourceFile.Substring($srcPath.Length).TrimStart('\', '/')
    $className = $relative -replace '\.java$', '' -replace '\\', '.'
} else {
    $className = [System.IO.Path]::GetFileNameWithoutExtension($SourceFile)
}

New-Item -ItemType Directory -Path $bin -Force | Out-Null

$sources = Get-ChildItem -Path $src -Recurse -Filter '*.java' -File | ForEach-Object { $_.FullName }

Write-Host "=== Kompilasi semua file di src/ ... ==="
javac -encoding UTF-8 -d $bin -sourcepath $src $sources
if ($LASTEXITCODE -ne 0) {
    Write-Host "Kompilasi gagal!" -ForegroundColor Red
    exit 1
}

Write-Host "=== Menjalankan $className ==="
java -cp $bin $className
